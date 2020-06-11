# sirkwie

De uitspraak van circuit is `[sɪrˈkwi]`, vandaar `sirkwie`.

### Deze opdracht is gemaakt door

| Naam | Studentnummer |
| --- | --- |
| Steven Liebregt | 2135519 |
| Rick Berkers | 2140241 |

## Diagrammen

Draai de `gradle` task `generateDiagrams` om de diagrammen in 
`docs/diagrams/*.puml` te converteren naar `svg` bestanden die in de map
`dist/diagrams` terecht komen.

Je kunt ook de volgende `JetBrains` plugin installeren om een extra view
te krijgen waarin je live-reloaded het diagram ziet terwijl je hem aan het
schrijven bent.
[https://plugins.jetbrains.com/plugin/7017-plantuml-integration](https://plugins.jetbrains.com/plugin/7017-plantuml-integration).

## Gradle Tasks

| task | beschrijving |
| --- | --- |
| :gui:run | Start de GUI simulatie op |
| :core:test | Run de tests van de core package |
| generateDiagrams | Genereer PNG images van de diagrammen |