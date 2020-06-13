# Features

### Creatiepatronen

 - Eenvoudige Creatiepatronen
    - Singleton
        - **NodeFactory**
        - **ImageLoader**
    - Factory
        - **NodeFactory**
        - **CircuitParserFactory**
 - Builder
    - **CircuitBuilder**
        
### Structuurpatronen

 - Eenvoudige Structuurpatronen
    - Facade
        - **CircuitLoaderFacade**
    - Flyweight
        - **ImageLoader**
 - Composite
    - **NodeComposite**
 
### Gedragspatronen

 - Eenvoudige Gedragspatronen
 - Visitor
    - **ANTLRVisitor**
    - **GraphNodeDrawingVisitor**
    - **TableNodeDrawingVisitor**
    - **NodeParentableVisitor**
 - Strategy
    - **ICircuitParser** (ANTLRCircuitParser, XMLCircuitParser)

## GUI

 - Views
    - LogView "Laat de calculatie flow zien als tree"
    - InputView "Buttons voor iedere input om te switchen"
    - ProbeView "Laat alle probes zien"
    - TextSimulationView "Laat de simulatie zien in een tabel formaat"
    - GraphNodeSimulationView "Laat de simulatie zien met nodes in een graphstream graph"
 - Propagation Delay, zichtbaar in LogView
 