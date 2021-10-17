package main

import (
	"bytes"
	"errors"
	"fmt"
	"io"
	"io/ioutil"
	"os"
	"path/filepath"
	"strings"

	"github.com/spf13/cobra"
)

func main() {
	if err := rootCmd.Execute(); err != nil {
		fmt.Println(err)
		os.Exit(1)
	}
}

var rootCmd = &cobra.Command{
	Use:   "post_node",
	Short: "post_node modifies js/ts generate proto code after prototools/protoc compilation",
	Args: func(cmd *cobra.Command, args []string) error {
		if len(args) != 1 {
			return errors.New("requires a single path argument")
		}
		if _, err := os.Stat(args[0]); os.IsNotExist(err) {
			return errors.New("supplied path does not exist")
		}
		return nil
	},
	Run: func(cmd *cobra.Command, args []string) {
		run(cmd, args)
	},
}

func run(cmd *cobra.Command, args []string) {
	files := findAllFiles(args[0], []string{".js", ".ts"})

	files = cleanFilesRemoveEmpty(files)
	cleanFilesRemoveGogo(files)

	fmt.Println("Finished js/ts post processing")
}

func findAllFiles(rootDir string, extensions []string) []string {
	var files []string

	err := filepath.Walk(rootDir, func(path string, info os.FileInfo, err error) error {
		if err != nil {
			return err
		}

		if info.IsDir() {
			return nil
		}

		for _, extension := range extensions {
			if filepath.Ext(info.Name()) == extension {
				files = append(files, path)
			}
		}

		return nil
	})
	if err != nil {
		panic(err)
	}

	return files
}

func cleanFilesRemoveEmpty(files []string) []string {
	var result []string

	for _, file := range files {
		f, err := os.Open(file)
		if err != nil {
			panic(err)
		}

		count, err := lineCounter(f)
		if err != nil {
			panic(err)
		}

		if count <= 1 {
			err = os.Remove(file)
			if err != nil {
				panic(err)
			}

			continue
		}

		result = append(result, file)
	}

	return result
}

func cleanFilesRemoveGogo(files []string) {
	for _, file := range files {
		input, err := ioutil.ReadFile(file)
		if err != nil {
			panic(err)
		}

		lines := strings.Split(string(input), "\n")

		for i, line := range lines {
			if strings.Contains(line, "gogo") {
				lines[i] = ""
			}
		}

		output := strings.Join(lines, "\n")
		err = ioutil.WriteFile(file, []byte(output), 0644)
		if err != nil {
			panic(err)
		}
	}
}

func lineCounter(r io.Reader) (int, error) {
	buf := make([]byte, 32*1024)
	count := 0
	lineSep := []byte{'\n'}

	for {
		c, err := r.Read(buf)
		count += bytes.Count(buf[:c], lineSep)

		switch {
		case err == io.EOF:
			return count, nil

		case err != nil:
			return count, err
		}
	}
}
