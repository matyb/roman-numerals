#roman-numerals [![Build Status](https://travis-ci.org/matyb/roman-numerals.png?branch=master)](https://travis-ci.org/matyb/roman-numerals)

to run manually you can
```mvn verify -Pmanual```
or, if you trust my tests
```mvn test```

I made note @ commit 95638dbcc0352a118e6e2b67f660ed553c5be955 to engage whomever I seek signoff from to provide feedback as to whether or not I have satisfactorily met their requirements. If this were a real project this is the point I'd solicit feedback.

Remaining Issues:
=================
* these issues aren't logged as issues, enumerating them here is pretty lazy
* the unit tests are testing more than one thing, which is generally uncool. for now i think the symmetry testing is more valuable, and they are testing a single behavior.
* strong coupling in the CLI class, that could be much better decomposed.
* entering invalid input crashes this application. 
* maven, travis, the unit and acceptance level testing; overkill given the lack of change in roman numeral system recently.
