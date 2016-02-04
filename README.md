#roman-numerals [![Build Status](https://travis-ci.org/matyb/roman-numerals.png?branch=master)](https://travis-ci.org/matyb/roman-numerals)

to run manually you can
```mvn verify -Pmanual```
or, if you trust my tests
```mvn test```

I made note @ commit 95638dbcc0352a118e6e2b67f660ed553c5be955 to engage whomever I seek signoff from to provide feedback as to whether or not I have satisfactorily met their requirements.

The rest of the commits are leveraging my code to leave things clean and tidy. That said there are...

Remaining Issues:
=================
* the unit tests are testing more than one thing, which is generally uncool. for now i think the symmetry testing is more valuable, and they are testing a single behavior.
* strong coupling in the CLI class, that could be much better decomposed.
* strong assumption that the Roman Numeral system is adequately deprecated such that it is no longer subject to change
* entering invalid input crashes this application. validation is something that warrants a dialog with the business.
* maven, travis, the unit and acceptance level testing; overkill. assuming developers will ever need to do something with this code, I feel they'll either be grateful or indifferent.
* front end is CLI, REST + shiny SPA would could be cool. 
