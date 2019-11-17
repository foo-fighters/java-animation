# Java Animator Example

1. Objects that can be drawn implement the `Drawable` interface.
2. The `Animator` object runs on another thread than the main program.
3. `Animator` calls `draw(Graphics g)` method of all `Drawable` objects in its `elementsToDraw` vector.
4. Each `Drawable` object is redrawn. Each object calculates its next position on its own, or with help from another object (e.g. a physics engine).