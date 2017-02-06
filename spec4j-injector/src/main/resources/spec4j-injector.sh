echo ""
echo "Profiler Runtime Injector"
echo "--java process list-------------------------"
echo "user        pid        start time"
echo "--------------------------------------------"
ps -ef|grep java|grep -v grep |awk '{print $1"        "$2"        "$5}'
echo "--------------------------------------------"
echo ""
java -Xbootclasspath/a:bootlib/tools.jar -jar spec4j-injector.jar