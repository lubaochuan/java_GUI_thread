# Two Buttons
* Declare Frame, 2 Labels, 2 Buttons
* Set up Frame (title, size, layout — 2x2 grid, close action)
* Instantiate Labels and Buttons
* Add them to the Frame
* Fill grid cells in reading order
* Create a listener for each button
* Here we simulate doing time consuming work using Pause
* We also split the access to the global variable and its update across the work
* Make the Frame visible
* Pause calls `Thread.sleep` for 1 sec
* No immediate update: long delay for multiple clicks
* Some updates are skipped
* Update of Progress value happens in proper order, and correctly
* Even though we allowed plenty of time for listeners to get and update value incorrectly
* There is a single event dispatch thread
* Each event action is placed on a queue, then executed in order
*  That’s why we can click repeatedly before an update
* Screen updates happen when the queue empties
* Although there are multiple action listeners, they don’t work in parallel; that’s why the time adds up

# Two Buttons with Access Race
Run `TwoThreadRace.java`:
* The value updates while buttons are being clicked
* It increments in arbitrary order
* Sometimes it seems to decrement
* Actually write-after-write hazard
* The total is incorrect