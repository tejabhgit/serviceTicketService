# API Proto Definitions for the RPS project

## Generated Client Libraries

- [Golang](https://github.azc.ext.hp.com/hp-rps/api-rps-proto-go)
- [Node](https://github.azc.ext.hp.com/hp-rps/api-rps-proto-node)
- [Java](https://github.azc.ext.hp.com/hp-rps/api-rps-proto-java)

## Development

### Install dependencies
```
make dependencies
```

### Format Proto files
```
make fmt
```

### Compile Proto files
```
make proto
```

### Compile Proto files and copy to local target dir
```
make proto_local
```

### Force image creation (Bypass breaking detection)
```
make image
```

## API Definition

### Path

New api definitions should be created in the following path:
./api/proto/rps/domains/`{domain}`/`{api_version}`/

Where:
* domains = domain your api/service is organized into
* api_version = version of your api (Defaults to v1)

### Creating a new Proto file

When creating an API, the resource model and resource api should be splitted into its own files.

eg:
* my_resource.proto = contains the my_resource model (message)
* my_resource_api.proto contains teh my_resource api (service)

To create a new Proto file, use the prototools cmd tool.
In the root of the repository run:
```bash
prototool create ./api/proto/rps/domains/library/v1/book_api.proto
```

### Resource types

Resource types should follow a predefined structure:

```protobuf
syntax = "proto3";

package rps.domains.library.v1;

option csharp_namespace = "Rps.Domains.Library.V1";
option go_package = "github.azc.ext.hp.com/hp-rps/api-rps-proto-go/api/rps/services/library/v1;libraryv1";
option java_multiple_files = true;
option java_outer_classname = "BookProto";
option java_package = "com.rps.domains.library.v1";
option objc_class_prefix = "RDL";
option php_namespace = "Rps\\Domains\\Library\\V1";

import "gogoproto/gogo.proto";
import "rps/types/meta/v1/meta.proto";

// Book represents a book in the library.
message Book {
  // ID unique identifier.
  string id = 1 [(gogoproto.customname) = "ID"];
  
  // ... add your propserties here ....

  // Meta object.
  rps.types.meta.v1.Meta meta = 100;
}
```

### Docs
- https://docs.buf.build/introduction
- https://cloud.google.com/apis/design