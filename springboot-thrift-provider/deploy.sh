process=`ps -ef | grep spring-boot:run | grep "springboot-thrift-provider"`
pid=`echo $process | cut -d ' ' -f 2`
echo pid = $pid

if  [ ! -n "$pid" ] ;then
    echo "springboot-thrift-provider未启动，不用kill"
else
    kill -9 $pid
    echo "kill springboot-thrift-provider"
fi


nohup mvn spring-boot:run &




