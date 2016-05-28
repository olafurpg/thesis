all: format
	lwatch
format:
	scalafmt -f code/unformatted.scala > code/target/formatted1.scala
clean:
	rm -rf code/target
