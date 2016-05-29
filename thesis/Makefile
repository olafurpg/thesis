all: format setup
	lwatch
setup:
	mv ~/Downloads/My\ Library.bib project.bib || true
format:
	mkdir -p code/target
	scalafmt -f code/unformatted.scala --maxColumn 35 > code/target/formatted1.scala
clean:
	rm -rf code/target
	clean_tex
