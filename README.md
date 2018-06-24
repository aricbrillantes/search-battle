# search-battle

There is a new ways to move your Bot now. Here are all the ways to move:

changing the int variable direction to UP/DOWN/LEFT/RIGHT/STAY. This will move your bot to the direction to direction was set to every time the game updates

changing the int variable move to UP/DOWN/LEFT/RIGHT/STAY moves your Bot ONCE (1 time) and your Bot will not move again after the game updates

adding ints to the variable moveList. It's an arraylist in which the game will check for the FIRST element in the list and perform that move for ONE game update (1 time) and will delete it, then it performs the next element in the list. This could mean you can have in the list; {UP, UP, LEFT, LEFT} to move your Bot up twice then left twice

Priority:

I made the game check for these variables each game update in a specific priority order:
- if there are elements inside moveList it will perform them until it's empty
- if move is set, the game will perform it ONLY if moveList is empty
- if direction is set AND move == NONE and moveList is empty, the game will use the Bot's direction

This is to give you guys more flexibility in making your Bot move in whatever way you want. 

If you want your bot to move up you can either:
- direction = UP;
- move = UP; (this moves your bot once so you have to set it again)
- moveList.add(UP); (this moves your bot once unless you add more UP's in this list

if you are confused or have any questions or concerns just ask me
