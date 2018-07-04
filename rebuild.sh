echo "Starting rebuilding process..."
SECONDS=0
if [ ! -d "build/" ]; then
  # Control will enter here if $DIRECTORY doesn't exist.
  echo "No previous build found..."
  echo "Creating directory build/"
  mkdir build
fi
javac -d ./build src/*.java
duration=$SECONDS
echo "BUILD COMPLETED ($(($duration % 60)) seconds)"