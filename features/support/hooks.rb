require 'date'

def current_time_in_millis( offset )
    ts = (Time.now.to_f * 1000 - offset).to_i
    rv = "#{ts}"
    return rv
end

def cleanup_shared_prefs
    clear_preferences("AppPrefs")
end

After('cleanup_after_run') do
    cleanup_shared_prefs()
end
    
After('@init_post_hour') do
    off = 1000 * 60 * 60
    curr_ts = current_time_in_millis(off)
    puts curr_ts
    set_preferences("AppPrefs", {:session_start_ts => "#{curr_ts}ms"})
end

After('@init_pre_hour') do
    off = 1000 * 60 * 30
    curr_ts = current_time_in_millis(off)
    puts curr_ts
    set_preferences("AppPrefs", {:session_start_ts => "#{curr_ts}ms"})
end
