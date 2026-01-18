# HytaleSystemGC

[![Java](https://img.shields.io/badge/Java-17%2B-orange)](https://openjdk.org/)
[![License](https://img.shields.io/badge/License-Unlicense-blue.svg)](LICENSE)
[![Build](https://img.shields.io/badge/Build-Maven-C71A36)](https://maven.apache.org/)

A lightweight Hytale server plugin that automatically triggers garbage collection at configurable intervals to help manage memory usage.

## ✨ Features

- 🔄 **Automatic scheduled garbage collection** - Set it and forget it
- ⚙️ **Configurable interval timing** - Customize GC frequency to your needs
- 📊 **Smart logging** - Only logs when significant memory (>1MB) is reclaimed
- 🪶 **Minimal overhead** - Uses daemon threads for zero impact on server shutdown

## 📋 Requirements

- Java 17 or higher
- Maven 3.6+ (for building)
- Hytale server with plugin support

## 🚀 Installation

### From Release

1. Download the latest release JAR from the [Releases](https://github.com/zuedev/HytaleSystemGC/releases) page
2. Place the JAR in your server's `plugins` folder
3. Restart the server

### Building from Source

```bash
# Clone the repository
git clone https://github.com/zuedev/HytaleSystemGC.git
cd HytaleSystemGC

# Build with Maven
mvn clean package

# The JAR will be in target/HytaleSystemGC-1.0.0.jar
```

## ⚙️ Configuration

The plugin can be configured by modifying the `GCConfig` class or programmatically at runtime:

| Setting                   | Default | Description                              |
| ------------------------- | ------- | ---------------------------------------- |
| `autoGcIntervalSeconds`   | 10      | Seconds between GC runs (0 to disable)   |
| `minMemoryThresholdBytes` | 1048576 | Minimum bytes freed before logging (1MB) |

### Programmatic Configuration

```java
GCConfig config = plugin.getConfig();
config.setAutoGcIntervalSeconds(30);  // Run every 30 seconds
config.setMinMemoryThresholdBytes(2097152);  // Log when >2MB freed
```

## 📁 Project Structure

```
HytaleSystemGC/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/zuedev/systemgc/
│       │       ├── AutoGC.java          # GC scheduling logic
│       │       ├── GCConfig.java        # Configuration management
│       │       ├── SystemGCPlugin.java  # Main plugin entry point
│       │       └── package-info.java    # Package documentation
│       └── resources/
│           └── hytale.json              # Plugin manifest
├── pom.xml                              # Maven build configuration
├── LICENSE                              # Unlicense (Public Domain)
├── CONTRIBUTING.md                      # Contribution guidelines
└── README.md                            # This file
```

## 🤝 Contributing

Contributions are welcome! Please read our [Contributing Guidelines](CONTRIBUTING.md) before submitting a pull request.

## 📄 License

This project is released into the public domain under the Unlicense - see the [LICENSE](LICENSE) file for details.
