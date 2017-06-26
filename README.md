# ciGoog

A pure ClojureScript/HTML web development environment with Cells Inside(tm), specifically kennytilton's Rube and, for the HTML, Google Closure.

## Step 1: Hello, world!
For Cells-driven UIs, "Hello World" consists of making an object and having it magically appear, because sufficient glue has been created to build the necessary UI thing. In this case, a CLJS map will become an HTML5 DOM element, a label in fact.

This parallels the "virtual DOM" of ReactJS, although in this case we are beating on the virtual world like its Daddy, not just emitting it for React to play with.

\[For a peak at where we are going, checkout [Qxia](https://github.com/kennytilton/qxia). That emits [qooxdoo Mobile](http://www.qooxdoo.org/5.0.1/pages/mobile.html) JS widgets instead of HTML5.\]
