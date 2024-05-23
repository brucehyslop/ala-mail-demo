package au.org.ala.ses

import grails.core.GrailsApplication
import grails.plugins.GrailsPluginManager
import grails.plugins.PluginManagerAware

class ApplicationController implements PluginManagerAware {

    GrailsApplication grailsApplication
    GrailsPluginManager pluginManager

    static final String FROM = 'test@ala.org.au'
    static final String TO = 'ala.test@bruce-hyslop.com'
    static final String SUBJECT = "Amazon SES test (AWS SDK for Java)";
    static final String HTMLBODY = "<h1>Amazon SES test (AWS SDK for Java)</h1>" +
            "<p>This email was sent with <a href='https://aws.amazon.com/ses/'>" +
            "Amazon SES</a> using the <a href='https://aws.amazon.com/sdk-for-java/'>" +
            "AWS SDK for Java</a>";

    static final String TEXTBODY = "This email was sent through Amazon SES " +
            "using the AWS SDK for Java.";

    def index() {

        sendMail {
            from FROM
            subject SUBJECT
            bcc TO
            html HTMLBODY
        }

        [grailsApplication: grailsApplication, pluginManager: pluginManager]
    }
}
