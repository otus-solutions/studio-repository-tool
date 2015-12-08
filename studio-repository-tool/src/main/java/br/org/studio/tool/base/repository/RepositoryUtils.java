package br.org.studio.tool.base.repository;

public class RepositoryUtils {

    private Repository repository;

    public RepositoryUtils(Repository repository) {
        this.repository = repository;
    }

    public String getName() {
        return repository.getConfiguration().getName();
    }

    public String getHost() {
        return repository.getConfiguration().getHost();
    }

    public String getPort() {
        return repository.getConfiguration().getPort();
    }

    public String getUser() {
        return repository.getConfiguration().getUser();
    }

    public String getPassword() {
        return repository.getConfiguration().getPassword();
    }

}
