#!/bin/bash

# Check if a directory path was provided
if [ -z "$1" ]; then
    echo "Usage: $0 <path-to-folder>"
    echo "Example: $0 src/main/java/com/distributed_order_system/distributed_order_system/orders"
    exit 1
fi

TARGET_DIR=$1

# Define the folders to create
FOLDERS=("controller" "dto" "service" "repository" "mapper" "entity")

# Loop through and create each folder
for folder in "${FOLDERS[@]}"; do
    mkdir -p "$TARGET_DIR/$folder"
    echo "Created: $TARGET_DIR/$folder"
done

echo "Structure setup complete in $TARGET_DIR"
