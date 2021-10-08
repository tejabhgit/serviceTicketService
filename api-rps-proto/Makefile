################################################################################
# Include defs
################################################################################
include Makefile.defs

################################################################################
# Target: all
################################################################################
.PHONY: all
all:

################################################################################
# Target clean
################################################################################
.PHONY: clean
clean:
	rm -Rf $(GEN_DIR)

################################################################################
# Target dependencies
################################################################################
.PHONY: dependencies
dependencies: dependencies_gogo dependencies_go dependencies_node dependencies_java

.PHONY: dependencies_gogo
dependencies_gogo:
	rm -Rf $(VENDOR_DIR)
	mkdir -p $(VENDOR_DIR)/github.com/gogo/protobuf
	$(GIT_CMD) clone --single-branch https://github.com/gogo/protobuf.git $(VENDOR_DIR)/github.com/gogo/protobuf

.PHONY: dependencies_go
dependencies_go:
	$(GO_CMD) get github.com/gogo/protobuf/proto
	$(GO_CMD) get github.com/gogo/protobuf/gogoproto
	$(GO_CMD) get github.com/gogo/protobuf/jsonpb
	$(GO_CMD) get github.com/gogo/protobuf/protoc-gen-gogo
	$(GO_CMD) get github.com/gogo/protobuf/protoc-gen-gogoslick
	$(GO_CMD) mod download
	$(GO_CMD) mod tidy

.PHONY: dependencies_node
dependencies_node:
	rm -Rf $(NODE_DIR)
	$(YARN_CMD) install

.PHONY: dependencies_java
dependencies_java:
	rm -Rf $(JAVA_PLUGINS_DIR)
	mkdir -p $(JAVA_PLUGINS_DIR)
	wget https://repo.maven.apache.org/maven2/io/grpc/protoc-gen-grpc-java/1.40.1/protoc-gen-grpc-java-1.40.1-linux-x86_64.exe -O $(JAVA_PLUGINS_DIR)/protoc-gen-grpc-java-osx.exe
	chmod 777 $(JAVA_PLUGINS_DIR)/protoc-gen-grpc-java-osx.exe

################################################################################
# Target image
################################################################################
.PHONY: image
image:
	mkdir -p $(IMAGE_DIR)
	$(BUF_CMD) build --exclude-imports --exclude-source-info -o $(IMAGE_DIR)/image.json
	$(BUF_CMD) build --exclude-imports --exclude-source-info -o $(IMAGE_DIR)/image.bin

################################################################################
# Target fmt
################################################################################
.PHONY: fmt
fmt:
	$(PROTOTOOL_CMD) format -w $(PROTO_DIR)

################################################################################
# Target breaking
################################################################################
.PHONY: breaking
breaking:
	$(BUF_CMD) breaking --against $(IMAGE_DIR)/image.bin

################################################################################
# Target proto
################################################################################
.PHONY: proto
proto: fmt clean breaking
	@ $(MAKE) proto_buf
	@ $(MAKE) proto_node
	@ $(MAKE) image

.PHONY: proto_buf
proto_buf:
	$(BUF_CMD) generate

.PHONY: proto_node
proto_node:
	mkdir -p $(GEN_DIR)/node

	$(BUF_CMD) build -o - | ./node_modules/.bin/grpc_tools_node_protoc \
		--plugin="./node_modules/.bin/grpc_tools_node_protoc_plugin" \
		--plugin="./node_modules/.bin/protoc-gen-ts" \
		-I api/proto \
		-I $(VENDOR_DIR)/github.com/gogo/protobuf \
		--js_out=import_style=commonjs,binary:$(GEN_DIR)/node \
		--grpc_out=grpc_js:$(GEN_DIR)/node \
		--ts_out=service=grpc-node,mode=grpc-js:$(GEN_DIR)/node \
		$(shell buf build -o - | buf ls-files -)
		
	@ $(MAKE) proto_node_post

.PHONY: proto_node_post
proto_node_post:
	$(GO_CMD) run -mod=readonly ./scripts/post_node/main.go $(GEN_DIR)/node/rps

################################################################################
# Target proto_local
################################################################################
.PHONY: proto_local
proto_local: proto
	rm -Rf ../api-rps-proto-node/api
	mkdir -p ../api-rps-proto-node/api
	cp -R $(GEN_DIR)/node/rps ../api-rps-proto-node/api/

	rm -Rf ../api-rps-proto-go/api
	mkdir -p ../api-rps-proto-go/api
	cp -R $(GEN_DIR)/go/rps ../api-rps-proto-go/api/

	rm -Rf ../api-rps-proto-java/
	mkdir -p ../api-rps-proto-java/src/main/java 
	mkdir -p ../api-rps-proto-java/.mvn
	cp -R $(GEN_DIR)/java/com ../api-rps-proto-java/src/main/java/com
	cp pom.xml ../api-rps-proto-java
	cp -R .mvn/ ../api-rps-proto-java
	cp mvnw ../api-rps-proto-java
	cd ../api-rps-proto-java && ./mvnw clean install

################################################################################
# Target scopes
################################################################################
.PHONY: scopes_list
scopes_list:
	@ $(BUF_CMD) build --exclude-source-info -o -#format=json | jq -r '.file[] .service | select(. != null) | .[].method[].options[].scopes[]' | sort | uniq
