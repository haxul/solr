import org.apache.solr.client.solrj.impl.HttpSolrClient
import org.apache.solr.client.solrj.impl.XMLResponseParser
import org.apache.solr.common.SolrInputDocument
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

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
    document.addField("id", "16")
    document.addField("name", "Kenmore")
    document.addField("price", "23599.99")
    solr.add(document)
    solr.commit()
    
    val client = HttpClient.newBuilder().build();
    val request = HttpRequest.newBuilder()
        .uri(URI.create("http://localhost:8983/solr/test_core/select?q=*%3A*"))
        .build();
    val response = client.send(request, HttpResponse.BodyHandlers.ofString());
    print(response.body())
}