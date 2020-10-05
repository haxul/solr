import org.apache.http.client.methods.HttpPost
import org.apache.http.entity.StringEntity
import org.apache.http.impl.client.HttpClients
import org.apache.solr.client.solrj.impl.HttpSolrClient
import org.apache.solr.client.solrj.impl.XMLResponseParser
import org.apache.solr.common.SolrInputDocument
import kotlin.random.Random

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
    document.addField("id", Random.nextInt(100, 1000000).toString())
    document.addField("name", "Starodubov")
    document.addField("price", "299.99")
    solr.add(document)
    solr.commit()
//

}
