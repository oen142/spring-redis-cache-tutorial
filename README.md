### 스프링 레디스 튜토리얼 프로젝트

- Spring Boot redis  클러스터 :
    - String
        - redis command set, get
    - lists
        - 순서있음 , value 중복 허용
        - redis command lpush, llen , lrange , lpop , rpop
    - hashs
        -  순서 없음, key 중복 허용 안함, value 중복 허용
        - hset , hget , hlen , hdel
    - sets
        - 순서 없음 , value 중복 허용 안함
        - saad , scard , smembers , sismember
    - sortedsets
      - 순서 있음, value 중복 허용 안함
      - zadd, zcard , zrange, zrank 
    - geo
      - 좌표 정보 처리 , 타입은 zset으로 저장
      - geoadd, geodist , geopos
    - hyperloglog
        - 집합의 원소의 개수 추정, 타입은 string 으로 저장
        - pfadd , pfcount
- Spring data redis
    - @Cacheable
    - @CachePut
    - @CacheEvict
    - @RedisHash
    
1. 캐시키 유효시간 정보를 저장할 Class 추가
2. RedisCacheConfig 추가
    - cacheManager의 configuration을 통해 캐시 정책을 변경한다.
    기본으로 사용하면 키의 expireTime을 세팅할 수 없으므로 개별적으로 캐시에 대한 TTL(time to live)
      값을 세팅하도록 내용을 추가한다. 기본 expireTime은 60초 이며 User의 경우는 180초로 세팅하도록 설정한다.
- @Cacheable
    - 레디스에 캐싱된 데이터가 있으면 반환하고 없으면 DB에서 조회한다음 Redis에 캐시합니다.
    어노테이션은 Method나 Type에 세팅을 할 수 있고 런타임에 수행된다.
      고정된 Key값 ChaceKey.User와 유동적으로 변하는값 msrl을 가지고 키를 조합아여 캐시를 조회한다.
      캐시의 이름은 "user::500" , "user::600"과 같이 "::"으로 구분된 이름으로 저장된다.
      result가 null이 아닌 경우에만 처리하며 위에서 설정한 expireTime = 180초로 TTL이 설정됩ㄴ디ㅏ.
      내용을 최초로 호출하면 다음과 같이 로그에서 쿼리 수행 내역을 확인할 수 있다.
      2번째 호출부터는 캐시된 데이터가 있으므로 쿼리가 수행되지 않는것을 확인할 수 있다.
      
- @CachePut
    - 레디스에 저장된 캐시 정보를 갱신합니다. 저장된 캐시가 없을 경우엔 캐시를 생성합니다.
    어노테이션은 Method나 Type에 세팅할 수 있고 런타임에 수행됩니다.
      파라미터로 넘어온 User객체로 DB를 업데이트 하고 msrl값과 고정키값으로 조합된 캐시키로 캐시를 찾아내
      갱신합니다. User객체를 다음과 같이 요청하여 Put요청을 보내면 user::33 이름으로 저장된 캐시 데이터가 갱신됩니다.
      
- @CacheEvict
    - 레디스에 저장된 캐시 정보를 삭제합니다. 
    - 삭제후 고정된 키값과 파라미터의 msrl로 캐시키를 조합하여 해당 캐시를 삭제한다.
- RedisHash
    - 레디스를 jpa repository를 사용하듯이 쓸수있게 해주는 어노테이션이다. 설정도 jpa와 별반 다르지 않다.
    - 캐시는 키값::@Id로 생성된다. 확인해보면 type은 hash로 저장된다
    - 그리고 hash내부에 저장된 key값을 보면 첫번째는 저장된 클래스의 정보 그다음부터는 각각의 필드로 key가 저장됨을 확인할
    수있다. hget을 통해 해당 key값에 저장된 데이터를 볼수 있다.


---
Redis는 발행 및 구독 모델의 구현 방법이 있다.
pub/sub는 특정한 주제에 대하여 해당 토픽을 구독한 모두에게 메시지를 발행하는 통신 방법이다.
이를테면 날씨 정보를 구독한 사람에게 주기적으로 날씨 정보를 보내거나
특정한 작업을 반복 수행하는 작업자에게 비동기적으로 작업을 보내 처리하거나 , 또는 현재 앱에 로그인한 유저에게 푸시를 발송하는 활동
들이 모두 pub sub의 원리로 만들어진다.

Redis는 RabbitMQ나 Kafka같이 전문적인 메시징 시스템의 pub sub 처럼 고도화된 기능을 제공하지 않지만
MemoryDB의 특성을 살려 단순하지만 가볍고 빠른 pub sub기능을 제공한다.

Redis Config 내용 추가
