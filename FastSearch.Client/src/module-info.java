module FastSearch.Client {
	requires com.google.gson;
	requires java.desktop;
	exports com.hit.Client.Messages;
	exports com.hit.dm;
	opens com.hit.dm;

}
