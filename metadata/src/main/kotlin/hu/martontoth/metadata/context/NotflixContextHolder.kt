package hu.martontoth.metadata.context

import org.springframework.stereotype.Component
import org.springframework.web.context.annotation.RequestScope


@Component
@RequestScope
class NotflixContextHolder {

    var context: NotflixContext = NotflixContext(sessionToken = null)

}

data class NotflixContext(
        val sessionToken: String?
)
