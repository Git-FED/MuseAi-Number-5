# Muse Number Five — Original 73-core-file tree

This is the supplied **core-file contract**, not an assertion that every listed file currently exists. It counts exactly 73 paths. It deliberately excludes any additional deployment, hosting, favicon, generated, or planning files beyond the original contract. The source plan mentions additional deployment/site files separately; they are not counted here.

```text
.
├── README.md
├── LICENSE
├── .gitignore
├── CHANGELOG.md
├── settings.gradle.kts
├── build.gradle.kts
├── gradle.properties
├── gradlew
├── gradlew.bat
├── keystore.properties.example
├── index.html
├── gradle/
│   └── wrapper/
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── .github/
│   └── workflows/
│       └── build.yml
├── app/
│   ├── build.gradle.kts
│   ├── proguard-rules.pro
│   └── src/
│       └── main/
│           ├── AndroidManifest.xml
│           ├── assets/
│           │   ├── slot-placeholder.html
│           │   └── group-relay-config.example.json
│           ├── java/
│           │   └── com/fedos/musenumberfive/
│           │       ├── MainActivity.kt
│           │       ├── Slots.kt
│           │       ├── SlotManager.kt
│           │       ├── MultiProfile.kt
│           │       ├── GroupTab.kt
│           │       ├── GroupRelayClient.kt
│           │       ├── GroupMessage.kt
│           │       └── GroupChatFragment.kt
│           └── res/
│               ├── layout/
│               │   ├── activity_main.xml
│               │   ├── fragment_group_chat.xml
│               │   └── item_group_message.xml
│               ├── values/
│               │   ├── strings.xml
│               │   └── themes.xml
│               ├── xml/
│               │   ├── backup_rules.xml
│               │   └── data_extraction_rules.xml
│               ├── drawable/
│               │   ├── ic_launcher_foreground.xml
│               │   └── ic_launcher_background.xml
│               ├── mipmap-anydpi-v26/
│               │   ├── ic_launcher.xml
│               │   └── ic_launcher_round.xml
│               ├── mipmap-mdpi/
│               │   ├── ic_launcher.png
│               │   └── ic_launcher_round.png
│               ├── mipmap-hdpi/
│               │   ├── ic_launcher.png
│               │   └── ic_launcher_round.png
│               ├── mipmap-xhdpi/
│               │   ├── ic_launcher.png
│               │   └── ic_launcher_round.png
│               ├── mipmap-xxhdpi/
│               │   ├── ic_launcher.png
│               │   └── ic_launcher_round.png
│               └── mipmap-xxxhdpi/
│                   ├── ic_launcher.png
│                   └── ic_launcher_round.png
├── assets/
│   ├── icon-source.svg
│   ├── icon.png
│   └── og-image.png
├── promo/
│   ├── 01-five-in-one.png
│   ├── 02-top-5-agents.png
│   ├── 03-perfectly-simple.png
│   ├── 04-always-active.png
│   ├── 05-no-contamination.png
│   ├── 06-separate-worlds.png
│   ├── 07-under-construction.png
│   └── 08-muse-5-mascot.png
├── docs/
│   ├── ultimate-file-tree.md
│   ├── DECISIONS.md
│   ├── SLOTS.md
│   ├── BUILDING.md
│   ├── TESTING.md
│   └── GROUP-CHAT.md
├── prompts/
│   ├── BUILD-PROMPT.md
│   ├── ICON-PROMPT.md
│   ├── PAGE-PROMPT.md
│   ├── README-PROMPT.md
│   └── PROMO-CODES-PROMPT.md
└── testing/
    ├── muse-number-five.flow.json
    ├── muse-number-five-group.flow.json
    └── sample-report.md
```

## Count check

| Contract group | Paths |
|---|---:|
| Root files | 11 |
| Gradle wrapper and GitHub build workflow | 3 |
| Android app build files, manifest, assets, Kotlin, and resources | 34 |
| Root artwork assets | 3 |
| Promo illustrations | 8 |
| Docs | 6 |
| Prompts | 5 |
| Testing examples | 3 |
| **Total** | **73** |

The Android group count includes 3 app-level build/manifest files, 2 app assets, 8 Kotlin files, 3 layout XML files, 2 values XML files, 2 XML policy files, 2 drawable XML files, 2 anydpi launcher XML files, and 10 density-specific launcher PNGs: 34 paths. Counts describe the supplied list, not file existence, completed implementation, test execution, a release, or a deployment.
