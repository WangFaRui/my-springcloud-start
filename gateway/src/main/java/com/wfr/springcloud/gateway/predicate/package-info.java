/**
 * predicate作用：简单来说就是路由匹配器。每一个predicate都会对当前客户端请求进行判断，是否满足匹配条件，
 * 如果满足则交给当前请求处理，这个"请求处理"可操作的东西就是org.springframework.web.server.ServerWebExchange,
 * 如果有多个predicate都满足，按照配置顺序只有第一个生效，换而言之，在匹配成功后，之后的predicate将不会再执行。
 */
package com.wfr.springcloud.gateway.predicate;