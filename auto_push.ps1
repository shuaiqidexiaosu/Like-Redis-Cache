# 自动提交本项目
function Push-Auto
{
    param (
        [int] $time = 0
    )
    try
    {
        git pull origin master;
        git add .;
        git commit -m "update content";
        git push -u origin master;
        git push -u github master;
        if ($time -eq 0)
        {
            Write-Host "push success, Waiting for seconds to clear the terminal..." -ForegroundColor Green
            Start-Sleep -s 4;
            Clear-Host
        }
        else
        {
            Write-Host "push success, Waiting for $time seconds to clear the terminal..." -ForegroundColor Green
            Start-Sleep -s $time;
            Clear-Host
        }
    }
    catch
    {
        Write-Host "push failed, please check your network or git config" -ForegroundColor Red
    }
}


Push-Auto -time 6