# GoCD task plugin for Archives

The archive plugin create archives (.zip, .tar, .tar.gz) from a list of files. The plugin requires a 2 parameters to define the name of the archive.

- *Archive Name*: The archive name, the task will recognize the archive type from the file name. (allows to declare Environment variables)
- *Archive Files*: A comma separated list of files, that should by archived. The Pattern allows to define a file or a folder, that should be included into the assembly. Optionally following syntax is possible: path{[bin]/*.exe}. This will catch all EXE files from the *path* and include them into the archive into the folder *bin* 

The plugin supports the *.env* files from the *GIT Info* plugin, to load additional environment variables.


## Building the code base

To build the jar, run `./gradlew clean test assemble`

## License

```plain
Copyright 2018 ThoughtWorks, Inc.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

## About the license and releasing your plugin under a different license

The skeleton code in this repository is licensed under the Apache 2.0 license. The license itself specifies the terms
under which derivative works may be distributed (the license also defines derivative works). The Apache 2.0 license is a
permissive open source license that has minimal requirements for downstream licensors/licensees to comply with.

This does not prevent your plugin from being licensed under a different license as long as you comply with the relevant
clauses of the Apache 2.0 license (especially section 4). Typically, you clone this repository and keep the existing
copyright notices. You are free to add your own license and copyright notice to any modifications.

This is not legal advice. Please contact your lawyers if needed.
