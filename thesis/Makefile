all: format
	lwatch
format:
	mkdir -p code/target
	scalafmt -f code/unformatted.scala > code/target/formatted1.scala
clean:
	rm -rf code/target
	clean_tex
