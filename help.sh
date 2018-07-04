if [ ! -d "build/" ]; then
  # Control will enter here if $DIRECTORY doesn't exist.
  echo "No previous build found..."
  sh rebuild.sh
  echo "Build process started..."
fi
cd build/
java Main --help
cd ..