package ru.otus.homework9.logger;

/**
 * Created by Антон Дементьев on 23.04.2018.
 */
public class LoggerController implements LoggerControllerMBean {
    private boolean enabled = true;

    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
