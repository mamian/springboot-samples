process=`ps -ef | grep spring-boot:run | grep "springboot-dubbo-consumer"`
pid=`echo $process | cut -d ' ' -f 2`
echo pid = $pid

if  [ ! -n "$pid" ] ;then
    echo "springboot-dubbo-consumer未启动，不用kill"
else
    kill -9 $pid
    echo "kill springboot-dubbo-consumer"
fi


nohup mvn spring-boot:run &




