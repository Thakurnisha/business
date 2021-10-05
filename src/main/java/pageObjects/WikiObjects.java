package pageObjects;

public interface WikiObjects {
	String teamSelection = "token-input-myTeams";  //ID
	String filterOptions = "//ul[@class='page_options_menu']"; //XPATH
	String filterButtonPath = "//*[@class='messages-button-group wiki-button-group']"; //XPATH
	String exitFullScreen = "//a[@title='Exit Fullscreen']"; //XPATH
	String viewCoutnPath = "//a[@class='view_count_reader refresh-count']/span"; //CLASS
	String wikiTemplate = "//ul[@id='wkTmpltsCntnr']/li"; //xpath
	String tableOfContentFirstLink = "//*[@id='wiki_toc']/a[1]"; //xpath
	String wikiContent = "wkContent"; //ID
}
