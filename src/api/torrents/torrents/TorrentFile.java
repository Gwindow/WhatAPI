package api.torrents.torrents;

import api.cli.Utils;

/**
 * A file in a torrent, stores the filename and size
 */
public class TorrentFile {
	private String filename;
	private long size;

	/**
	 * Parse torrent file information from the string
	 *
	 * @param fileData torrent file information as the api returns it
	 *                 format is: file_name{{{file_size}}}
	 */
	public TorrentFile(String fileData){
		String split[] = fileData.split("([{]{3}|[}]{3})");
		filename = split[0];
		size = Long.parseLong(split[1]);
	}

	public String getFilename(){
		return filename;
	}

	public long getSize(){
		return size;
	}

	@Override
	public String toString(){
		return "TorrentFile [name=" + filename + ", size=" + Utils.toHumanReadableSize(size) + "]";
	}
}
