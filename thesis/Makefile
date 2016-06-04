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
	dot -Tpdf code/router.dot -o target/router.pdf || true
clean:
	rm -rf target
	clean_tex
