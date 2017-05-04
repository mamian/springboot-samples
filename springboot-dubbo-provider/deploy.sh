process=`ps -ef | grep spring-boot:run | grep "springboot-dubbo-provider"`
pid=`echo $process | cut -d ' ' -f 2`
echo pid = $pid

if  [ ! -n "$pid" ] ;then
    echo "springboot-dubbo-provider未启动，不用kill"
else
    kill -9 $pid
    echo "kill springboot-dubbo-provider"
fi


nohup mvn spring-boot:run &




