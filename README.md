# INFO
Test for AgileEngine:
Program found elements in file and build path to them.

# HOW TO RUN
 java -cp AgileEngineTask-1.0-jar-with-dependencies.jar com.agileengine.task.TagTokenFounder ./samples/sample-0-origin.html ./samples/sample-2-container-and-clone.html make-everything-ok-button
 
 OR FOR DEFAULT TOKEN "make-everything-ok-button"
 
 java -cp AgileEngineTask-1.0-jar-with-dependencies.jar com.agileengine.task.TagTokenFounder ./samples/sample-0-origin.html ./samples/sample-2-container-and-clone.html
 
# RESULT 
1. sample-1-evil-gemini.html :

java -cp AgileEngineTask-1.0-jar-with-dependencies.jar com.agileengine.task.TagTokenFounder ./samples/sample-0-origin.html ./samples/sample-1-evil-gemini.html m
ake-everything-ok-button
[main] INFO com.agileengine.task.TagTokenFounder - -----------------------------------------------------
[main] INFO com.agileengine.task.TagTokenFounder - FOUNDED ELEMENT: <a class="btn btn-success" href="#check-and-ok" title="Make-Button" rel="done" onclick="javascript:window.okDone(); return false;"> M
ake everything OK </a>
[main] INFO com.agileengine.task.TagTokenFounder - WITH 3 EQUALS ATTRIBUTES : [a[class="btn btn-success"], a[title="Make-Button"], a[onclick="javascript:window.okDone(); return false;"]]
[main] INFO com.agileengine.task.TagTokenFounder - PATH TO ELEMENT: html -> body -> div -> div -> div[2] -> div -> div -> div[1] -> a[1]
[main] INFO com.agileengine.task.TagTokenFounder - -----------------------------------------------------

2. sample-2-container-and-clone.html :

java -cp AgileEngineTask-1.0-jar-with-dependencies.jar com.agileengine.task.TagTokenFounder ./samples/sample-0-origin.html ./samples/sample-2-container-and-clon
e.html make-everything-ok-button
[main] INFO com.agileengine.task.TagTokenFounder - -----------------------------------------------------
[main] INFO com.agileengine.task.TagTokenFounder - FOUNDED ELEMENT: <a class="btn test-link-ok" href="#ok" title="Make-Button" rel="next" onclick="javascript:window.okComplete(); return false;"> Make e
verything OK </a>
[main] INFO com.agileengine.task.TagTokenFounder - WITH 3 EQUALS ATTRIBUTES : [a[rel="next"], a[href="#ok"], a[title="Make-Button"]]
[main] INFO com.agileengine.task.TagTokenFounder - PATH TO ELEMENT: html -> body -> div -> div -> div[2] -> div -> div -> div[1] -> div -> a
[main] INFO com.agileengine.task.TagTokenFounder - -----------------------------------------------------

3. sample-3-the-escape.html :

java -cp AgileEngineTask-1.0-jar-with-dependencies.jar com.agileengine.task.TagTokenFounder ./samples/sample-0-origin.html ./samples/sample-3-the-escape.html ma
ke-everything-ok-button
[main] INFO com.agileengine.task.TagTokenFounder - -----------------------------------------------------
[main] INFO com.agileengine.task.TagTokenFounder - FOUNDED ELEMENT: <a class="btn btn-success" href="#ok" title="Do-Link" rel="next" onclick="javascript:window.okDone(); return false;"> Do anything per
fect </a>
[main] INFO com.agileengine.task.TagTokenFounder - WITH 4 EQUALS ATTRIBUTES : [a[rel="next"], a[class="btn btn-success"], a[href="#ok"], a[onclick="javascript:window.okDone(); return false;"]]
[main] INFO com.agileengine.task.TagTokenFounder - PATH TO ELEMENT: html -> body -> div -> div -> div[2] -> div -> div -> div[2] -> a
[main] INFO com.agileengine.task.TagTokenFounder - -----------------------------------------------------

4. sample-4-the-mash.html :

java -cp AgileEngineTask-1.0-jar-with-dependencies.jar com.agileengine.task.TagTokenFounder ./samples/sample-0-origin.html ./samples/sample-4-the-mash.html make
-everything-ok-button
[main] INFO com.agileengine.task.TagTokenFounder - -----------------------------------------------------
[main] INFO com.agileengine.task.TagTokenFounder - FOUNDED ELEMENT: <a class="btn btn-success" href="#ok" title="Make-Button" rel="next" onclick="javascript:window.okFinalize(); return false;"> Do all
GREAT </a>
[main] INFO com.agileengine.task.TagTokenFounder - WITH 4 EQUALS ATTRIBUTES : [a[rel="next"], a[class="btn btn-success"], a[href="#ok"], a[title="Make-Button"]]
[main] INFO com.agileengine.task.TagTokenFounder - PATH TO ELEMENT: html -> body -> div -> div -> div[2] -> div -> div -> div[2] -> a
[main] INFO com.agileengine.task.TagTokenFounder - -----------------------------------------------------
