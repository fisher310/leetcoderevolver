count=`cat file.txt | wc -l`
if [ count -ge 10 ]; then
  head -10 file.txt | tail -1
fi
