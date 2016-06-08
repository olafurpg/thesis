all: format setup plot
	lwatch
update: setup format
setup:
	mv ~/Downloads/My\ Library.bib project.bib || true
plot:
	gnuplot plots/months.gp
	# Rscript plots/file_size.R # || true > target/file_sizes.tex || true
	# Rscript plots/macro.R # || true > target/file_sizes.tex || true
	# ./plots/macro.py < data/macro.csv > target/macro.tex
	# ./plots/macro.py < data/file_sizes.csv > target/file_sizes.tex
	# ./plots/macro.py < data/micro.csv > target/micro.tex
	# ./plots/macro.py < data/installs.csv > target/installs.tex
format:
	mkdir -p target
	scalafmt -f code/unformatted.scala --maxColumn 35 > target/formatted1.scala
	clang-format code/terrible.cpp > target/unterrible.cpp
	gofmt code/gofmt.go > target/gofmt.go
	dot -Tpdf code/router.dot -o target/router.pdf || true
clean:
	rm -rf target
	clean_tex
