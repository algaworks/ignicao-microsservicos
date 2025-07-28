find ./* -type d -name ".git" -exec rm -rf "{}" \;
find ./* -type f -name ".git" -exec rm -rf "{}" \;
find ./* -type f -name ".gitmodules" -exec rm -rf "{}" \;
find ./* -type d -name ".gradle" -exec rm -rf "{}" \;