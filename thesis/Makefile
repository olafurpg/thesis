all: format setup
	lwatch
update: setup format
setup:
	mv ~/Downloads/My\ Library.bib project.bib || true
format:
	mkdir -p target
	scalafmt -f code/unformatted.scala --maxColumn 35 > target/formatted1.scala
	clang-format code/terrible.cpp > target/unterrible.cpp
	gofmt code/gofmt.go > target/gofmt.go
	dot code/gofmt.go > target/gofmt.go
clean:
	rm -rf code/target
	clean_tex
