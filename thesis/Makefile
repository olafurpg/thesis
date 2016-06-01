all: format setup
	lwatch
update: setup format
setup:
	mv ~/Downloads/My\ Library.bib project.bib || true
format:
	mkdir -p code/target
	scalafmt -f code/unformatted.scala --maxColumn 35 > code/target/formatted1.scala
	clang-format code/terrible.cpp > code/target/unterrible.cpp
	gofmt code/gofmt.go > code/target/gofmt.go
clean:
	rm -rf code/target
	clean_tex
