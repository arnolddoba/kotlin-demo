package co.saltpay.kotlindemo.graphql

import graphql.GraphQL
import graphql.schema.GraphQLSchema
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class GraphQlConfig {

    @Bean
    fun graphQL(schema: GraphQLSchema?): GraphQL? {
        val builder = GraphQL.newGraphQL(schema)
        return builder.build()
    }
}
