The Game:
The game itself is an isometric game which uses Java swing for its creation. The player character is controlled via
 the keyboard directional arrows, and movement is achieved via the X character. The use can switch the view by pressing
 the Z character. This game was developed using Java 11.

Aim of the Game:
The aim of the game is to interact with all 3 chests by walking into them. The character can also interact with other
 various objects within the game such as the other sprite characters, a sign post and a hole. This is also achieved by
 walking into the items.

Design Principle & Pattern:
For this project, I decided to use a factory design pattern. The factory design pattern is a creational pattern
 that uses factory methods to deal with the problem of creating objects without having to specify the exact class
 of the object that will be created. I done this by creating sprite classes (DefaultSprite, GreenSprite etc..) by
 calling upon sprite factory. This is specified in an interface called Spriteable. I then implemented the child
 classes, overridden them, rather than calling a constructor.
I took apart the given god class and created seperate classes for this. The reason for this was to keep the SRP of the program.
I also seperated the user controls from the god class as that class was only to be used for the game view. I put these controls in
 a class named PlayerController.
The class named IsoController contains all the code for the isometric view. Similarly, the ImageController class contains the code
 for accessing the images in the resource folder. The Properties class contains the code for dealing with the image and tile sizes.
I grouped together cohesive elements into methods and types by using the factory design pattern and putting equivelant code into
 specific classes. I achieved abstraction by using the Spriteable interface for my Sprite types.

Issues:
I failed to remove the asynchnorous issue from the runner. I aimed to fix this issue by making it a singleton class.
I also failed to make the paint method inside the GameView class quicker. This method contains an inner for loop for
 creating the grid, which is quadratic in Big O notation. I planned on making this into a recursive function.