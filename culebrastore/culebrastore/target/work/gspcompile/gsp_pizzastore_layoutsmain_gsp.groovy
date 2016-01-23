import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_pizzastore_layoutsmain_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/layouts/main.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',11,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('layoutTitle','g',12,['default':("Grails")],-1)
})
invokeTag('captureTitle','sitemesh',12,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',12,[:],2)
printHtmlPart(1)
invokeTag('layoutHead','g',13,[:],-1)
printHtmlPart(1)
invokeTag('layoutResources','r',14,[:],-1)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',15,[:],1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(3)
invokeTag('username','sec',18,[:],-1)
printHtmlPart(4)
createClosureForHtmlPart(5, 3)
invokeTag('link','g',18,['controller':("logout")],3)
printHtmlPart(6)
createTagBody(3, {->
expressionOut.print(message(code: 'springSecurity.logout.link'))
})
invokeTag('remoteLink','g',19,['class':("logout"),'controller':("logout")],3)
printHtmlPart(1)
})
invokeTag('ifLoggedIn','sec',20,[:],2)
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(6)
createClosureForHtmlPart(7, 3)
invokeTag('link','g',22,['controller':("login"),'action':("auth")],3)
printHtmlPart(1)
})
invokeTag('ifNotLoggedIn','sec',23,[:],2)
printHtmlPart(8)
invokeTag('layoutBody','g',25,[:],-1)
printHtmlPart(1)
invokeTag('layoutResources','r',26,[:],-1)
printHtmlPart(1)
})
invokeTag('captureBody','sitemesh',27,[:],1)
printHtmlPart(9)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1417963680000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
