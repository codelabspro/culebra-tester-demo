import pizzashop.Product
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_pizzastore_product_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/product/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: productInstance, field: 'name', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("product.name.label"),'default':("Name")],-1)
printHtmlPart(2)
invokeTag('textField','g',10,['name':("name"),'required':(""),'value':(productInstance?.name)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: productInstance, field: 'description', 'error'))
printHtmlPart(4)
invokeTag('message','g',16,['code':("product.description.label"),'default':("Description")],-1)
printHtmlPart(2)
invokeTag('textArea','g',19,['name':("description"),'cols':("40"),'rows':("5"),'maxlength':("1000"),'required':(""),'value':(productInstance?.description)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: productInstance, field: 'price', 'error'))
printHtmlPart(5)
invokeTag('message','g',25,['code':("product.price.label"),'default':("Price")],-1)
printHtmlPart(6)
invokeTag('field','g',28,['name':("price"),'value':(fieldValue(bean: productInstance, field: 'price'))],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: productInstance, field: 'status', 'error'))
printHtmlPart(7)
invokeTag('message','g',34,['code':("product.status.label"),'default':("Status")],-1)
printHtmlPart(2)
invokeTag('select','g',37,['name':("status"),'from':(productInstance.constraints.status.inList),'required':(""),'value':(productInstance?.status),'valueMessagePrefix':("product.status")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: productInstance, field: 'tags', 'error'))
printHtmlPart(8)
invokeTag('message','g',43,['code':("product.tags.label"),'default':("Tags")],-1)
printHtmlPart(6)
invokeTag('select','g',46,['name':("tags"),'from':(pizzashop.Tag.list()),'multiple':("multiple"),'optionKey':("id"),'size':("5"),'value':(productInstance?.tags*.id),'class':("many-to-many")],-1)
printHtmlPart(9)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1417870354000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
