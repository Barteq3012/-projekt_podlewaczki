garden: main.o create_files.o create_garden.o water.o setup.o
	$(CC) -o garden main.o create_files.o create_garden.o water.o setup.o -lm

main.o: main.c 
	$(CC) -c main.c 

create_garden.o: create_garden.c create_garden.h  
	$(CC) -c create_garden.h create_garden.c 

create_files.o: create_files.h create_files.c
	$(CC) -c create_files.h create_files.c

water.o: water.h water.c
	$(CC) -c water.h water.c

setup.o: setup.h setup.c 
	$(CC) -c setup.h setup.c 

.PHONY: clean

clean:
	-rm *.o *.gch 
