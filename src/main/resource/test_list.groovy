import com.theoxao.base.common.annotations.Api
import com.theoxao.base.common.annotations.Autowired
import com.theoxao.common.RestResponse
import com.theoxao.test.App
import groovy.transform.Field
import org.springframework.data.mongodb.core.MongoTemplate

@Field
@Autowired
MongoTemplate mongoTemplate

@Api(uri = "/app/add")
RestResponse<?> add(String name, String desc) {
    println(name)
    App app = new App()
    App.Companion.future().thenApply { pp ->
        pp.reverse()
    }
    app.name = name
    app.desc = desc
    println(app.name)
    mongoTemplate.save(app)
    return new RestResponse<?>(200)
}
