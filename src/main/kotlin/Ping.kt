import org.apache.solr.client.solrj.impl.HttpSolrClient
import org.apache.solr.client.solrj.impl.XMLResponseParser
import org.apache.solr.common.SolrInputDocument

object SolrClient {
    fun get(): HttpSolrClient {
        val urlString = "http://localhost:8983/solr/test_core"
        val solr = HttpSolrClient.Builder(urlString).build()
        solr.parser = XMLResponseParser()
        return solr
    }
}


fun main() {

    val solr = SolrClient.get()

    val document = SolrInputDocument()
    document.addField("id", "123456")
    document.addField("name", "Kenmore Dishwasher")
    document.addField("price", "599.99")
    solr.add(document)
    solr.commit()
}