echo test > test.txt
cd Cache/src
javac test2.java -Djava.library.path=.
::-Djava.library.path=%ProgramFiles(x86)%\Java\slick
pause