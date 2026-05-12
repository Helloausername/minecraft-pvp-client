# Minecraft PvP Client AI SLOP!!!

A fully functional, modular Minecraft PvP client built with Fabric for Minecraft 1.21.4.

## Features

### Combat Modules (4)
- **Aim Assist** - Smoothly aims at nearby enemies (configurable speed & distance)
- **Auto Clicker** - Automatically attacks at set intervals (configurable CPS)
- **Critical Hits** - Forces critical hits on attacks
- **Reach Display** - Shows current attack reach distance

### Render Modules (5)
- **ESP** - Highlights nearby entities with colored boxes
- **Fullbright** - Increases gamma to see in darkness
- **Keystrokes** - Displays currently pressed keys
- **FPS Counter** - Shows current frames per second
- **Custom Crosshair** - Customizable crosshair rendering

### Movement Modules (3)
- **Auto Sprint** - Automatically sprints when moving
- **Speed** - Increases movement speed (configurable multiplier)
- **No Fall** - Negates fall damage

### Misc Modules (2)
- **Toggle Sprint** - Persistent sprint mode without holding key
- **Auto Log** - Automatically disconnects when health is low

## Installation

### Option 1: Download Pre-Built JAR
1. Go to [Releases](https://github.com/Helloausername/minecraft-pvp-client/releases)
2. Download `pvp-client-1.0.0.jar`
3. Place in `.minecraft/mods/` folder
4. Launch Minecraft with Fabric loader

### Option 2: Build from Source

#### Requirements
- Java 21+
- Gradle (included via gradlew)
- Fabric Loader installed

#### Build Steps
```bash
# Clone the repository
git clone https://github.com/Helloausername/minecraft-pvp-client.git
cd minecraft-pvp-client

# Build the mod
./gradlew build

# Output JAR: build/libs/pvp-client-1.0.0.jar
```

## Project Structure

```
src/main/java/com/pvpclient/
├── PvPClient.java              # Main mod entry point
├── modules/                    # All game modules
│   ├── Module.java            # Base module class
│   ├── ModuleCategory.java    # Module categories
│   ├── ModuleManager.java     # Module registration & management
│   ├── combat/                # Combat cheats
│   │   ├── AimAssist.java
│   │   ├── AutoClicker.java
│   │   ├── CriticalHits.java
│   │   └── Reach.java
│   ├── render/                # Visual enhancements
│   │   ├── ESP.java
│   │   ├── Fullbright.java
│   │   ├── Keystrokes.java
│   │   ├── FPSCounter.java
│   │   └── Crosshair.java
│   ├── movement/              # Movement modifications
│   │   ├── AutoSprint.java
│   │   ├── Speed.java
│   │   └── NoFall.java
│   └── misc/                  # Miscellaneous
│       ├── ToggleSprint.java
│       └── AutoLog.java
├── config/                    # Configuration
│   ├── KeyBindings.java      # Keybind management
│   └── Config.java           # Config file handling
├── utils/                     # Utility functions
│   ├── RenderUtils.java
│   ├── EntityUtils.java
│   └── PlayerUtils.java
└── mixin/                     # Mixin injections
    ├── ClientTickMixin.java
    └── RenderMixin.java

src/main/resources/
├── fabric.mod.json            # Mod metadata
├── pvpclient.mixins.json      # Mixin configuration
└── assets/pvpclient/lang/
    └── en_us.json            # Language file
```

## Configuration

Configuration files are saved in: `pvpclient_config/settings.properties`

Example configuration:
```properties
aim_assist_speed=3.0
aim_assist_distance=20.0
auto_clicker_cps=10.0
auto_log_health=5.0
```

## Keybindings

- **Right Shift** - Toggle GUI (when implemented)
- **M** - Toggle Module visibility

Keybindings can be customized in Minecraft's Controls menu.

## Adding New Modules

1. Create a new class extending `Module` in the appropriate category folder
2. Implement `onTick()` and/or `onRender()` methods
3. Register in `ModuleManager.registerModules()`

Example:
```java
public class MyModule extends Module {
    public MyModule() {
        super("My Module", "Description", ModuleCategory.MISC);
    }

    @Override
    public void onTick() {
        // Code runs every game tick
    }

    @Override
    public void onRender() {
        // Code runs every render frame
    }
}
```

## Troubleshooting

### Mod not loading?
- Ensure Fabric Loader is installed
- Check that the JAR is in `.minecraft/mods/`
- Look for error messages in the Minecraft launcher console

### Modules not working?
- Check that the module is enabled (look for console messages)
- Verify Minecraft version matches (1.21.4)
- Try disabling other mods that might conflict

## Performance Tips

- Disable modules you're not using
- Lower ESP distance if experiencing lag
- Reduce auto-clicker CPS if getting banned
- Use Toggle Sprint instead of Auto Sprint for better performance

## Disclaimer

This client is for **educational purposes only**. Use responsibly and always check server rules before using on multiplayer servers. Some features may be considered cheating and could result in bans. The creators are not responsible for any consequences of misuse.

## License

MIT License - See [LICENSE](LICENSE) file for details

## Contributing

Contributions are welcome! Please:
1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Submit a pull request

## Support

For issues or questions, please open a GitHub issue.
