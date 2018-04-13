redis.call('set',"we",'bar')
return redis.call('get','we')