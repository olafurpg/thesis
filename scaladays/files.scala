object files {
  file.touch()
  file.delete() // unlike the Java API, also works on directories as expected (deletes children recursively)
  file.clear() // If directory, deletes all children; if file clears contents
  file.renameTo(newName: String)
  file.moveTo(destination)
  file.copyTo(destination) // unlike the default API, also works on directories (copies recursively)
  file.linkTo(destination) // ln file destination
  file.symbolicLinkTo(destination) // ln -s file destination
  file.setOwner(user: String) // chown user file
  file.setGroup(group: String) // chgrp group file
  Seq(file1, file2) `>:` file3 // same as cat file1 file2 > file3
  Seq(file1, file2) >>: file3 // same as cat file1 file2 >> file3
  file.isReadLocked / file.isWriteLocked / file.isLocked
  File.newTemporaryDirectory() / File.newTemporaryFile() // create temp dir/file
}
